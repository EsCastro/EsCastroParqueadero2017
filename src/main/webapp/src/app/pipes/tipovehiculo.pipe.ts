import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'tipovehiculo'
})
export class TipovehiculoPipe implements PipeTransform {

  transform(value: number): string {
    let nombre: string;
    if(value === 1){
      nombre = 'CARRO';
    }else if(value === 2){
      nombre = 'MOTO';
    }
    return nombre;
  }

}
