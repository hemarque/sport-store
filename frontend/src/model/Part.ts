export class Part {
  id: number;
  type: string;
  option: string;
  price: number;

  constructor(id: number, type: string, option: string, price: number) {
    this.id = id;
    this.type = type;
    this.option = option;
    this.price = price;
  }
}