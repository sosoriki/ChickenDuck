export interface Forecast{

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
    speed:number;
    deg:number;
    date:string;

}