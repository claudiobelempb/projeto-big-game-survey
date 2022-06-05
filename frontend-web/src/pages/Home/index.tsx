import React from 'react';
import { Link } from 'react-router-dom';

import { ReactComponent as ImgArrow } from '../../assets/arrow.svg';
import { ReactComponent as ImgGame } from '../../assets/gamer.svg';

import { Header } from '../../components/Header';
import './styles.css';

const HomePage: React.FC = () => {
  return (
    <>
      <Header />
      <main className='home__container'>
        <div className='home__text'>
          <h1 className='home__title'>Quais jogos a galera gosta mais?</h1>
          <h3 className='home__subtitle'>
            Clique no botão abaixo e saiba quais são os jogos que os gamers
            estão escolhendo!
          </h3>
          <Link to={'/records'}>
            <div className='home__actions'>
              <button className='home__btn'>QUERO SABER QUAIS SÃO</button>
              <div className='home__btn_icon'>
                <ImgArrow />
              </div>
            </div>
          </Link>
        </div>

        <ImgGame className='home__image' />
      </main>
    </>
  );
};

export default HomePage;
