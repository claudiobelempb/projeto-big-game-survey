import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Chart from 'react-apexcharts';
import {
  buildBarSeries,
  getPlatformChartData,
  getGenderChartData
} from './helpers';

import { barOptions, pieOptions } from './chart-options';
import { Header } from '../../components/Header';
import { Filter } from '../../components/Filter';

import './styles.css';

type BarChartData = {
  x: string;
  y: number;
};

type PieChartData = {
  labels: string[];
  series: number[];
};

const initialPieData = {
  labels: [],
  series: []
};

const BASE_URL = 'http://localhost:8080';

const Charts: React.FC = () => {
  const [barChartData, setBarChartData] = useState<BarChartData[]>([]);
  const [platformdata, setPlatformData] =
    useState<PieChartData>(initialPieData);
  const [genderdata, setGenderData] = useState<PieChartData>(initialPieData);

  useEffect(() => {
    (async () => {
      try {
        const recors = await axios.get(`${BASE_URL}/records-date-page`);
        const games = await axios.get(`${BASE_URL}/games`);

        const barData = buildBarSeries(games.data, recors.data.content);
        setBarChartData(barData);

        const platformData = getPlatformChartData(recors.data.content);
        setPlatformData(platformData);

        const genderdata = getGenderChartData(recors.data.content);
        setGenderData(genderdata);
      } catch (error) {
        console.log(error, 'Errror');
      }
    })();
  }, []);

  return (
    <>
      <Header />
      <div className='page__container'>
        <Filter label='VER TABELA' href='/records' />
        <div className='chart__container'>
          <div className='top__related'>
            <h1 className='top__related_title'>Jogos Mais votados</h1>
            <div className='games__container'>
              <Chart
                options={barOptions}
                type='bar'
                height={650}
                series={[{ data: barChartData }]}
              />
            </div>
          </div>
          <div className='charts__container'>
            <div className='platform__chart'>
              <h2 className='chart__title'>Plataformas</h2>
              <Chart
                options={{ ...pieOptions, labels: platformdata?.labels }}
                type='donut'
                series={platformdata?.series}
              />
            </div>
            <div className='gender__chart'>
              <h2 className='chart__title'>Gêneros</h2>
              <Chart
                options={{ ...pieOptions, labels: genderdata?.labels }}
                type='donut'
                series={genderdata?.series}
              />
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Charts;
