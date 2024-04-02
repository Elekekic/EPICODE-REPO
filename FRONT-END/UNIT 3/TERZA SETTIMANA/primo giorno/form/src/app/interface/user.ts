export interface User {

   firstName: string;
    lastName: string;
    email: string;
    biography: string;
    gender: { label: string; value: string }[];
    password: string;
    avatar: string; 
    confirmPassword: string;
    

}
