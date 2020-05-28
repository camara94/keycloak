import { Injectable, OnInit } from '@angular/core';
import { KeycloakInstance } from 'keycloak-js';
declare var Keycloak: any;

@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {

  public keycloakInstance: KeycloakInstance;

  constructor() { }


   init = async () => {
    console.log("Security Initialisation ...");
    this.keycloakInstance = new Keycloak({
      url: 'http://localhost:8180/auth',
      realm: 'ecomerce-realm',
      clientId: 'AngularProductsApp'
    });

    await this.keycloakInstance.init({
      //onLoad: 'login-required',
      onLoad: 'check-sso'
    });

    console.log(this.keycloakInstance.token);
  }
}
