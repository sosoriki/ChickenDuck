# WeatherDuck
## _A ChickenDuck Application_

### Overview
The WeatherDuck application is an application aimed at telling the current weather, specific details, and future forecasts of any location. 
This application uses two APIs to pull information about the Weather and Location. 
First, a Google Maps API is called to get the location and that location is put through the OpenWeather API to get the weather details.
The Google Maps API also serves multiple other services such as autofilling a user's search or converting the location to longitude and latitude.
The frontend is built with Angular 12 and the backend is build with Spring Boot 2.7.0. 


### Installation
- Clone this respository
- Install below node_modules
  - `npm install ngx-google-places-autocomplete`
  - `npm install -D @types/google.maps`
  - `npm install @googlemaps/js-api-loader`
  - `npm install angular-bootstrap-md --save`
  - `npm install sweetalert2`
- Generate API keys at `https://developers.google.com/maps` and `https://openweathermap.org/api` (don't worry there are free ones!)
- Insert API keys to backend like so 

  ![This is an image](https://i.postimg.cc/hP1CXNsx/image.png)
  
- Insert Google Maps API key to the frontend like so

  ![This is an image](https://i.postimg.cc/KY8vXXq5/image.png)
  ![This is an image](https://i.postimg.cc/PfYHRrfj/image.png)


### How to run
- To run the frontend, cd into this directory: `cd weatherApp/src/main/resources/static/weatherApplication`
- Once in directory, type and enter `ng serve --o`, this will open up the tab at `localhost:4200` when it finishes compiling
- To run the backend, open the project on the IDE of your choice and run the application
- Make sure your SQL instance is correctly configures in applications.properties


### The application
- When the application is fully started, the user will be prompted with a login page
- From here you can login with an existing account from your SQL or register a new account

![This is an image](https://i.postimg.cc/MTHj0Ph9/image.png)

- After successful log in you will be taken to the main page in which you can search up your location and get weather details

![This is an image](https://i.postimg.cc/qBCWjkXd/image.png)


### Future plans
1. Integrate advertisement for the application 
    - This will allow for a non-free version of the API keys so that it can be a fully fledged application
2. Increase security measures 
    - The application only has checking for account in the frontend, there should be some error checking in the backend
    - There also needs to be more security questions for the user to choose from
3. Give some sort of benefits for making an account
    - This would require us to allow users to use the application without an account
    - If the user would make an account and login, there will be more benefits such as information shown
    - Bring maybe a subscription base or donations to keep application running and the account would not be shown advertisements
