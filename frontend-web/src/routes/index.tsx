import React from 'react';

import { BrowserRouter } from 'react-router-dom';
import { AppUseRoutes } from './app.routes';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <AppUseRoutes />
    </BrowserRouter>
  );
};

export { AppRoutes };
