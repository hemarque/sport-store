import { Part } from './Part';

export class Product {
  id: number;
  type: string;
  name: string;
  price: number;
  parts: Part[];

  constructor(id: number, type: string, name: string, price: number, parts: Part[]) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.price = price;
    this.parts = parts;
  }

  getTotalPrice(): number {
    return this.parts.reduce((total, part) => total + part.price, 0);
  }
}
