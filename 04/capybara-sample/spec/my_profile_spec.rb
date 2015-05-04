require "rspec"
require "capybara"
require "capybara/dsl"
require "capybara/rspec"

Capybara.default_driver = :selenium
Capybara.app_host = 'http://localhost:8080'

describe "My Profile page", :type => :feature do

  it "contains character's name and species" do
    # Login as a known test user
    visit '/'
    fill_in 'Username', :with => 'test123'
    fill_in 'Password', :with => 'password123'
    click_button 'Login'

    # Open the 'My Profile' page and check its content
    visit '/profile'
    expect(find('#playername')).to have_content 'Test User 123'
    expect(find('#speciesname')).to have_content 'orc'
  end

end
