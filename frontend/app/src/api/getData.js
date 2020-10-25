import * as APP_INFO from './apiconfig'
import axios from 'axios'

export const getCompanyInfo = (params) =>
  new Promise((resolve, reject) => {
    axios
      .post(APP_INFO.getCompanyInfo, params)
      .then((res) => resolve(res.data))
      .catch((err) => reject(err))
  })

export const getCompanyList = (params) =>
  new Promise((resolve, reject) => {
    axios
      .post(APP_INFO.getCompanyList, params)
      .then((res) => resolve(res.data))
      .catch((err) => reject(err))
  })

export const getConsumeList = (params) =>
  new Promise((resolve, reject) => {
    axios
      .post(APP_INFO.getConsumeList, params)
      .then((res) => resolve(res.data))
      .catch((err) => reject(err))
  })

export const consume = (params) =>
  new Promise((resolve, reject) => {
    axios
      .post(APP_INFO.consume, params)
      .then((res) => resolve(res.data))
      .catch((err) => reject(err))
  })

export const charge = (params) =>
  new Promise((resolve, reject) => {
    axios
      .post(APP_INFO.charge, params)
      .then((res) => resolve(res.data))
      .catch((err) => reject(err))
  })

export const getActivity = (params) =>
  new Promise((resolve, reject) => {
    axios
      .post(APP_INFO.getActivity, params)
      .then((res) => resolve(res.data))
      .catch((err) => reject(err))
  })
