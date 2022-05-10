# Selenium Assignment Korpa Bence JDJKCH

## Target

www.lichess.org

## Use

gradle build

## Tests performed:

### Login (loginTest())

The driver logs in with the credentials given in the config file (/config/config.txt)
the test test if the driver is not logged in before login, and logged in after.

### Logout (logoutTest())

The driver performs login and the logout. After that checks if it is actually logged out.

### Title (titleTest())

The test checks if the title is correct

### Static Page (StaticPageTest())

The test checks a given class's text, and also if an element with an id is actually there.

### Study

The driver logs in. After logging in we can get to Study upload form, that is only accessible for logged in users.
The driver creates a study by uploading a random pgn file. The file's location can be found in the config file.
After creating the study the test checks if it was actually created, and the file was uploaded.

### Hover

During the Study form creating the driver has to get through a hover. The test cheks if a hover is actually there, and it shows the correct elements after hovering.


