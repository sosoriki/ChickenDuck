export interface Weather{

    latitude: number;
    longitude: number;
    temp: number;
    max_temp: number;
    min_temp: number;
    condition: string;
    description: string;
    formattedAddress:string;
    
    feels_like:string;
    pressure:string;
    humidity:string;
    iconUrl:string;
}