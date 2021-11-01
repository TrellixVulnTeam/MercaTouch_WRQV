import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiendasadminComponent } from './tiendasadmin.component';

describe('TiendasadminComponent', () => {
  let component: TiendasadminComponent;
  let fixture: ComponentFixture<TiendasadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TiendasadminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TiendasadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
