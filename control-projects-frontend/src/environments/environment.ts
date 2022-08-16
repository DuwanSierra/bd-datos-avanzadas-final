// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  appName: "Control projects UD",
  apiUrl: 'http://localhost:8080',
  areaInteresEndpoint: 'http://localhost:8080/area-interes',
  sedeEndpoint: 'http://localhost:8080/sede',
  profesorEndpoint: 'http://localhost:8080/profesor',
  rolEndpoint: 'http://localhost:8080/rol',
  cargoEndpoint: 'http://localhost:8080/cargo',
  facultadEndpoint: 'http://localhost:8080/facultad',
  grupoEndpoint: 'http://localhost:8080/grupo-investigacion',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
