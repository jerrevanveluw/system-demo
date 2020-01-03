import React from 'react';
import { User } from '../models';

type UserLiProps = {
  user: User;
};

export const UserLi = ({ user }: UserLiProps) => (
  <div key={user.name}>
    {user.name} is {user.age}
  </div>
);
