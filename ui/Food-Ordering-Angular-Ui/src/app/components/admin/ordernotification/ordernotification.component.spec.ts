import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdernotificationComponent } from './ordernotification.component';

describe('OrdernotificationComponent', () => {
  let component: OrdernotificationComponent;
  let fixture: ComponentFixture<OrdernotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdernotificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdernotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
