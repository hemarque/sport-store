import { Part } from './Part';

export class Product {
  type: string;
  name: string;
  parts: Part[];

  constructor(type: string, name: string, parts: Part[]) {
    this.type = type;
    this.name = name;
    this.parts = parts;
  }

  getTotalPrice(): number {
    return this.parts.reduce((total, part) => total + part.price, 0);
  }
}
