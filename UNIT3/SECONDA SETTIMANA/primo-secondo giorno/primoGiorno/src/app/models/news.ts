// Interfaccia che mi serve un po' d'appertutto
export interface News {
    tags: string[]; 
    title: string; 
    reactions: number; 
    body: string; 
    active: boolean; 
    id: number; 
}
