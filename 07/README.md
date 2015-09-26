# Sample code for Chapter 7

`uad` contains a dummy Java application representing the User Activity Dashboard. It also includes a Vagrantfile and a set of Ansible files, so the application can be provisioned inside a Vagrant VM. Note that the Java application does not actually do anything apart from print a welcome message.

To build the Java app: `ant package`

To create a Vagrant VM and provision the app: `vagrant up`
