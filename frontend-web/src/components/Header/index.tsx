import React from 'react';
import './styles.css';

import { ReactComponent as ImgLogo } from '../../assets/logo.svg';
import { Link } from 'react-router-dom';

const Header: React.FC = () => {
  return (
    <header className='header__container'>
      <Link to='/'>
        <div className='header__logo'>
          <ImgLogo />
          <span className='text__coral'>Big Game</span>
          <span className='text__white'>Survey</span>
        </div>
      </Link>
    </header>
  );
};

export { Header };
