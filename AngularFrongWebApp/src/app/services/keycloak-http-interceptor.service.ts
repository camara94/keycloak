import { KeycloakSecurityService } from './keycloak-security.service';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KeycloakHttpInterceptorService implements HttpInterceptor {


  constructor( private keycloakSecurityService: KeycloakSecurityService ) { }

  intercept( req: HttpRequest<any>, next: HttpHandler ): Observable<HttpEvent<any>> {
    console.log('Request Http Interceptor .....');
    if ( !this.keycloakSecurityService.keycloakInstance.authenticated ) {
      return next.handle(req);
    }
    const request = req.clone({
      setHeaders: {
        Authorization: 'Bearer ' + this.keycloakSecurityService.keycloakInstance.token
      }
    });
    return next.handle(request);
  }

}
