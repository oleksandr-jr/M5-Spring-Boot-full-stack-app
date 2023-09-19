import type {Race} from "@/types/Race";
import type {Profession} from "@/types/Profession";


export default interface Player {
    id: number;
    name: string;
    title: string;
    race: Race;
    profession: Profession;
    birthday: string;
    banned: boolean;
    experience: number;
    level: number;
    untilNextLevel: number;
}