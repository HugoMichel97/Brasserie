import { Client } from 'src/app/model/client';
import { Brasseur } from './../../model/brasseur';
import { BrasseurService } from './../../services/brasseur.service';
import { ClientService } from './../../services/client.service';
import { AuthentificationService } from './../../services/authentification.service';
import { Component, OnInit } from '@angular/core';
import {
  faArrowRightFromBracket,
  faArrowRightToBracket,
  faBeer,
  faCalendarDay,
  faCalendarDays,
  faCookieBite,
  faHome,
  faHouseUser,
  faPeopleGroup,
  faShoppingBasket,
  faThumbsUp,
  faWheatAwn,
} from '@fortawesome/free-solid-svg-icons';
import { Compte } from 'src/app/model/compte';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  iconAccueil = faHome;
  iconBieres = faBeer;
  iconSnack = faCookieBite;
  iconEvt = faCalendarDays;
  iconTeam = faPeopleGroup;
  iconLog = faArrowRightToBracket;
  iconLogout = faArrowRightFromBracket;
  iconCompte = faHouseUser;
  iconPanier = faShoppingBasket;
  iconResa = faCalendarDay;
  iconIngr = faWheatAwn;
  iconAvis = faThumbsUp;

  public constructor(private authService: AuthentificationService) {}

  ngOnInit(): void {}

  get login() {
    return localStorage.getItem('login');
  }

  get role() {
    return localStorage.getItem('role');
  }

  get id() {
    return localStorage.getItem('id');
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  logout() {
    localStorage.clear();
  }
}
