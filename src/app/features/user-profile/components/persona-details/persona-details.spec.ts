import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonaDetails } from './persona-details';

describe('PersonaDetails', () => {
  let component: PersonaDetails;
  let fixture: ComponentFixture<PersonaDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PersonaDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PersonaDetails);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
