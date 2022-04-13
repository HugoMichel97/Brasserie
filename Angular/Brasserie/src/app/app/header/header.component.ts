import { Client } from 'src/app/model/client';
import { Brasseur } from './../../model/brasseur';
import { BrasseurService } from './../../services/brasseur.service';
import { ClientService } from './../../services/client.service';
import { AuthentificationService } from './../../services/authentification.service';
import { Component, OnInit } from '@angular/core';
import {
  faArrowLeft,
  faArrowRightFromBracket,
  faArrowRightToBracket,
  faArrowsLeftRightToLine,
  faBeer,
  faCalendarDay,
  faCookieBite,
  faHome,
  faHouseUser,
  faPeopleGroup,
} from '@fortawesome/free-solid-svg-icons';
import { Compte } from 'src/app/model/compte';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  client: Client | undefined;
  brasseur: Brasseur | undefined;
  iconAccueil = faHome;
  iconBieres = faBeer;
  iconEvt = faCalendarDay;
  iconTeam = faPeopleGroup;
  iconLog = faArrowRightToBracket;
  iconLogout = faArrowRightFromBracket;
  iconCompte = faHouseUser;

  public constructor(
    private authService: AuthentificationService,
    private clientService: ClientService,
    private brasseurService: BrasseurService
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('role') == 'client') {
      this.clientService
        .getByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          this.client = new Client(result.id, result.mail);
        });
    } else if (localStorage.getItem('role') == 'brasseur') {
      this.brasseurService
        .getByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          this.brasseur = new Brasseur(result.id, result.mail);
        });
    }
  }

  get login() {
    return localStorage.getItem('login');
  }

  get role() {
    return localStorage.getItem('role');
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  logout() {
    localStorage.clear();
  }
}
