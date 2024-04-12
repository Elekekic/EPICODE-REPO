<div  align="center" >
 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Angular_Logo_SVG.svg/2560px-Angular_Logo_SVG.svg.png" width="400" height="100" /> 

  This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.12. 
</div>


## Development server


- Esegui in terminale : `npm i json-server@0.17.4`,`npm i json-server-auth`, `npm i @auth0/angular-jwt`,  `npm i concurrently`
- Modificare la parte script del package json con questi comandi :
```
"scripts": {
    "ng": "ng",
    "start": "ng serve -o",
    "build": "ng build",
    "watch": "ng build --watch --configuration development",
    "test": "ng test",
    "backend": "json-server-auth --watch db.json --port 4201",
    "fullstack": "concurrently \"npm run backend\" \"npm run start\""
  },
  ```
- Poi: `npm run fullstack` 
- Naviga su: `http://localhost:4200/`.
- L'applicazione si ricaricherà automaticamente se modifichi qualsiasi cosa dai file sorgenti.


### Sono stati utilizzati:

> ![Static Badge](https://img.shields.io/badge/HTML-%23E34F26?style=for-the-badge&logo=html5&labelColor=black)  ![Static Badge](https://img.shields.io/badge/SCSS-%23CC6699?style=for-the-badge&logo=SASS&labelColor=black)
   ![Static Badge](https://img.shields.io/badge/Bootstrap-%237952B3?style=for-the-badge&logo=Bootstrap&labelColor=black)   ![Static Badge](https://img.shields.io/badge/TypeScript-%233178C6?style=for-the-badge&logo=typescript&labelColor=black)

<br> 

<h2 > Come funziona </h2>

// da finire
