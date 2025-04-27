export class Part {
  type: string;
  option: string;
  price: number;

  constructor(type: string, option: string, price: number) {
    this.type = type;
    this.option = option;
    this.price = price;
  }
}
