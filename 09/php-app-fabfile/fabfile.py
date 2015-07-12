from fabric.api import *
import time

# The hosts we want to deploy to.
# You can pass these as command line args if you prefer.
env.hosts = [
    'ubuntu@ec2-54-247-42-167.eu-west-1.compute.amazonaws.com',
    'ubuntu@ec2-54-195-178-142.eu-west-1.compute.amazonaws.com',
    'ubuntu@ec2-54-246-60-34.eu-west-1.compute.amazonaws.com'
] 

elb_name = 'elb'
instance_ids = {
    'ec2-54-247-42-167.eu-west-1.compute.amazonaws.com': 'i-d1f52a7c',
    'ec2-54-195-178-142.eu-west-1.compute.amazonaws.com': 'i-d8ee3175',
    'ec2-54-246-60-34.eu-west-1.compute.amazonaws.com': 'i-dbee3176'
}

def detach_from_lb():
    local("aws elb deregister-instances-from-load-balancer \
            --load-balancer-name %s \
            --instances %s" % (elb_name, instance_ids[env.host]))

    puts("Waiting for connection draining to complete")
    time.sleep(10)

def attach_to_lb():
    local("aws elb register-instances-with-load-balancer \
            --load-balancer-name %s \
            --instances %s" % (elb_name, instance_ids[env.host]))

    while "3" not in local(
            "aws elb describe-load-balancers --load-balancer-names elb \
            | jq '.LoadBalancerDescriptions[0].Instances | length'", 
            capture=True):
        puts("Waiting for 3 instances")
        time.sleep(1)

    while "OutOfService" in local(
            "aws elb describe-instance-health --load-balancer-name elb", 
            capture=True):
        puts("Waiting for all instances to be healthy")
        time.sleep(1)

# The Apache start/stop commands are different from the listing in the book
# because I ended up using a Bitnami AMI for testing.
# Apache is installed in a non-standard way as part of the Bitnami stack.
def stop_apache():
    sudo("/opt/bitnami/ctlscript.sh stop apache")

def start_apache():
    sudo("/opt/bitnami/ctlscript.sh start apache")

def git_checkout(tag):
    #with cd('/var/www/htdocs/my-php-app'):
    with cd('/home/bitnami/htdocs/my-php-app'):
        run('git fetch --tags')
        run("git checkout %s" % tag)

def healthcheck():
    attempts = 10
    while "OK" not in run('curl http://localhost/my-php-app/healthcheck.php'):
        attempts -= 1
        if attempts == 0:
            abort("Healthcheck failed for 10 seconds")
        time.sleep(1)

def deploy_to_prod(tag):
    detach_from_lb()
    stop_apache()
    git_checkout(tag)
    start_apache()
    healthcheck()
    attach_to_lb()
