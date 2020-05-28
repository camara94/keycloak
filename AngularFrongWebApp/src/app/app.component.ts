import { KeycloakSecurityService } from './services/keycloak-security.service';
import { Component, OnInit } from '@angular/core';

export class TokenParsed {
  exp: string;
  iat: string;
  nonce: string;
  realm_access: string;
  resource_access: string;
  session_state: string;
  name: string;
  given_name: string;
  email: string;
  family_name: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(public securityService: KeycloakSecurityService) { }

  title = 'AngularFrongWebApp';

  ngOnInit() {

  }

  onLogout() {
    this.securityService.keycloakInstance.logout();
  }

  onLogin() {
    this.securityService.keycloakInstance.login();
  }

  onChangePassword() {
    this.securityService.keycloakInstance.accountManagement();
  }

  isAppManager(): boolean {
    return this.securityService.keycloakInstance.hasRealmRole('app-manager');
  }

  getTokenParsed(): any {
    return this.securityService.keycloakInstance.tokenParsed;
  }



}
