import React from 'react';
import { User } from 'graphql-simple-bindings/user';

type UserLiProps = {
  user: User;
};

export const UserLi = ({ user }: UserLiProps) => (
  <div key={user.name}>
    {user.name} is {user.age}
  </div>
);
