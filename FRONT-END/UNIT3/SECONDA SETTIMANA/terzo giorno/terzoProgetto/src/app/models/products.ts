export interface Products
    {
    id: number,
    title: string,
    description: string,
    price: number,
    brand: string,
    thumbnail: string,
  }

  export interface CartItem extends Products {
    amount:   number
    totalPrice: number
  }


