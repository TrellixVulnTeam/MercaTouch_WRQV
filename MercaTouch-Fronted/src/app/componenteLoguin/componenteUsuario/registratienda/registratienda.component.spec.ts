import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistratiendaComponent } from './registratienda.component';

describe('RegistratiendaComponent', () => {
  let component: RegistratiendaComponent;
  let fixture: ComponentFixture<RegistratiendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistratiendaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistratiendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
