/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import VaccinationService from '@/entities/vaccination/vaccination.service';
import { Vaccination } from '@/shared/model/vaccination.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('Vaccination Service', () => {
    let service: VaccinationService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new VaccinationService();
      currentDate = new Date();
      elemDefault = new Vaccination(0, 'AAAAAAA', 0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', currentDate, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            dateAndTime: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Vaccination', async () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            age: 1,
            job: 'BBBBBB',
            phoneNumber: 'BBBBBB',
            address: 'BBBBBB',
            dateAndTime: dayjs(currentDate).format(DATE_FORMAT),
            vaccineType: 'BBBBBB',
            applicator: 'BBBBBB',
            endStatus: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            dateAndTime: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Vaccination', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
