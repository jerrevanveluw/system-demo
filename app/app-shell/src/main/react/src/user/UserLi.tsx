import React from 'react';
import { User } from './user.model';

type UserLiProps = {
  user: User;
};

export const UserLi = ({ user }: UserLiProps) => (
  <div key={user.name}>
    {user.name} is {user.age} (fav col: {user.favouriteColour})
  </div>
);
