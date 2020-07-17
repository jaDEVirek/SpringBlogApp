import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

/**
 * routes variable for storage all of route's
 */
const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class ApplicationRoutingModule {
};
