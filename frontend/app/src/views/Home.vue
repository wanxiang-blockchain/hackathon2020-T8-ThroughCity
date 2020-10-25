<template>
  <div class="home">
    <van-pull-refresh v-model="isLoading" success-text="刷新成功" @refresh="onRefresh">
      <van-notice-bar left-icon="volume-o" text="In Blokchcain We Trust" />
      <div class="card-wrapper">
        <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
          <van-swipe-item class="banner">
            <div class="left">
              <van-image
                width="3rem"
                height="3rem"
                fit="cover"
                src="https://fang-oss.haozu.com/app/index/2020/09/17/ol61af2ihi.jpg?x-oss-process=image/resize,m_fill,w_492,h_356/quality,Q_90/crop,g_center,x_0,y_0,h_356,w_492"
              />
            </div>
            <div class="right">
              <ul>
                <li class="space">空间： 华虹国际大厦 9层</li>
                <li>日租金： 900token</li>
                <li>押金： 27000token</li>
                <li>到期日： 2022-10-24日</li>
              </ul>
            </div>
          </van-swipe-item>
        </van-swipe>
      </div>
      <h4>数字园区</h4>
      <div class="card-wrapper">
        <div class="icon-list-wrapper">
          <ul class="icon-list">
            <li class="item" v-for="item in park" :key="item.name">
              <svg class="icon" aria-hidden="true">
                <use :xlink:href="item.icon" />
              </svg>
              <span class="text">{{ item.name }}</span>
            </li>
          </ul>
        </div>
        <h4>数字园区</h4>
        <div class="card-wrapper">
          <div class="icon-list-wrapper">
            <ul class="icon-list">
              <li class="item" v-for="item in park" :key="item.name">
                <svg class="icon" aria-hidden="true">
                  <use :xlink:href="item.icon" />
                </svg>
                <span class="text">{{ item.name }}</span>
              </li>
            </ul>
          </div>
        </div>
        <h4>积分服务</h4>
        <div class="card-wrapper">
          <div class="icon-list-wrapper">
            <ul class="icon-list">
              <li class="item" v-for="item in token" :key="item.name">
                <svg class="icon" aria-hidden="true">
                  <use :xlink:href="item.icon" />
                </svg>
                <span class="text">{{ item.name }}</span>
              </li>
            </ul>
          </div>
        </div>
        <h4>附近</h4>
        <div class="card-wrapper">
          <ul class>
            <li v-for="item in activity" :key="item.name">
              <van-card
                :price="item.amount"
                :desc="item.content"
                :title="item.name"
                thumb="https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2307976301,4112990994&fm=26&gp=0.jpg"
              />
              <van-divider />
            </li>
          </ul>
        </div>
      </div>
    </van-pull-refresh>
  </div>
</template>

<script>
import { getActivity } from '../api/getData'
export default {
  name: 'Home',
  data() {
    return {
      activity: [],
      isLoading: false,
      park: [
        {
          icon: '#icon-remenhuodong',
          name: '热门活动',
          action: () => {}
        },
        {
          icon: '#icon-shoujichongzhi',
          name: '积分充值',
          action: () => {}
        },
        {
          icon: '#icon-zhangdan',
          name: '账单查询',
          action: () => {}
        },
        {
          icon: '#icon-jinrongguwen',
          name: '专属管家',
          action: () => {}
        }
      ],
      token: [
        {
          icon: '#icon-zhuanzhang',
          name: '积分转账',
          action: () => {}
        },
        {
          icon: '#icon-shuidianjiaofei',
          name: '水电缴费',
          action: () => {}
        },
        {
          icon: '#icon-fangchan',
          name: '物业缴费',
          action: () => {}
        },
        {
          icon: '#icon-zhuangxiu',
          name: '楼层保洁',
          action: () => {}
        },
        {
          icon: '#icon-zulin',
          name: '场地租赁',
          action: () => {}
        },
        {
          icon: '#icon-baoxian',
          name: '企业采购',
          action: () => {}
        },
        {
          icon: '#icon-fenzu',
          name: '企业团餐',
          action: () => {}
        },

        {
          icon: '#icon-gengduo',
          name: '更多服务',
          action: () => {}
        }
      ]
    }
  },
  methods: {
    onRefresh() {
      this.isLoading = true
      getActivity().then((res) => {
        this.isLoading = false
        if (res && res.returnCode % 1000 === 0 && res.data && res.data.length) {
          this.activity = res.data
        }
      })
    }
  },
  mounted() {
    getActivity().then((res) => {
      if (res && res.returnCode % 1000 === 0 && res.data && res.data.length) {
        this.activity = res.data
      }
    })
  }
}
</script>
<style lang="stylus" scoped>
.my-swipe .van-swipe-item {
  color: #fff;
  font-size: 20px;
  line-height: 150px;
  text-align: center;
  background-color: #869ba7;
}

.home {
  h4 {
    padding: 0 16px;
    font-size: 16px;

    & + .card-wrapper {
      margin-top: 5px;
    }
  }

  .banner {
    padding: 20px;
    height: 150px;
    display: flex;
    justify-content: space-between;
    overflow: hidden;

    .left {
      border-radius: 10px;
      overflow: hidden;
    }

    .right {
      padding-top: 5px;
    }

    ul {
      height: 100%;
      display: flex;
      flex-direction: column;

      li {
        text-align: left;
        font-size: 14px;
        height: 16px;
        line-height: 16px;

        &.space {
          margin-bottom: 20px;
          font-size: 16px;
          font-weight: 600;
        }
      }
    }
  }
}

.van-card {
  background-color: #fff;
}

.icon-list-wrapper {
  .icon-list {
    width: 100%;
    display: flex;
    flex-flow: wrap;
    justify-content: space-between;

    .item {
      padding: 10px;
      width: 25%;
      display: flex;
      align-items: center;
      flex-direction: column;
      justify-content: center;
      font-size: 28px;

      .text {
        padding-top: 6px;
        font-size: 14px;
      }
    }
  }
}
</style>
