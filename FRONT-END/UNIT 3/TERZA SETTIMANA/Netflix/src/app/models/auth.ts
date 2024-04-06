export interface Auth {
    accessToken: string,
    user: {
        name: string,
        id: string,
        email: string
        favorites: []; 
    }
}
