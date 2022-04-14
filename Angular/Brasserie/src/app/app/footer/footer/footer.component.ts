import { faEnvelope, faHome, faPhone } from '@fortawesome/free-solid-svg-icons';
import { Component, OnInit } from '@angular/core';
import {
  faFacebook,
  faInstagram,
  faTwitter,
} from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent implements OnInit {
  iconHome = faHome;
  iconMail = faEnvelope;
  iconTel = faPhone;
  iconInsta = faInstagram;
  iconTwitter = faTwitter;
  iconFb = faFacebook;

  constructor() {}

  ngOnInit(): void {}
}
