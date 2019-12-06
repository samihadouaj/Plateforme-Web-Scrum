import { Component, OnInit } from '@angular/core';
export interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/project/userID',     title: 'USERA',         icon:'nc-circle-10',       class: '' },

];

@Component({
  selector: 'app-sidebar-project',
  templateUrl: './sidebar-project.component.html',
  styleUrls: ['./sidebar-project.component.scss']
})
export class SidebarProjectComponent implements OnInit {

  constructor() { }

  public menuItems: any[];
  ngOnInit() {
      this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
