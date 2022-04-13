import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-carte-credit',
  templateUrl: 'carte-credit.component.html',
  styleUrls: ['./carte-credit.component.css']
})
export class CarteCreditComponent implements OnInit {

  @Input() cardNumber?: string;
  @Input() clientName?: string;
  @Input() expirationDate?: string;

  constructor() { }

  ngOnInit(): void {
  }

}
