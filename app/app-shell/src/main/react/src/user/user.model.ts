import { User as ExternalUser } from 'graphql-simple-bindings/user';

export type User = {
  name: string;
  age: number;
  favouriteColour?: string;
};

export const internalize = ({ name, age, favouriteColour }: ExternalUser): User => ({
  name,
  age,
  favouriteColour,
});
