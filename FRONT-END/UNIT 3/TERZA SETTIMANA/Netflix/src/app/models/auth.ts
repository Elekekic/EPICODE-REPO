export interface Auth {
    accessToken: string,
    user: {
        name: string,
        id: number,
        email: string
    }
}
