import { KeycloakSecurityService } from './keycloak-security.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export class Supplier {
  id: number;
  name: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class SuppliersService {

  constructor(
      private httpClient: HttpClient,
      private securityService: KeycloakSecurityService
    ) { }

  getSuppliers() {
    /*const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*')
      .set('Authorization', 'Bearer' + this.securityService.keycloakInstance.token);*/
    return this.httpClient.get('http://localhost:8083/suppliers', {headers: new HttpHeaders({ Authorization: 'Bearer ' + this.securityService.keycloakInstance.token }) });
  }
}
