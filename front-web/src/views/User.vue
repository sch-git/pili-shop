<template>
  <main>
    <div class="my-container">
      <!--设置-->
      <div class="search-nav">
        <div class="search-nav-container">
          <ul>
            <li>我的设置</li>
          </ul>
        </div>
      </div>
      <div class="main">
        <div class="sidebar-main">
          <v-sidebar/>
        </div>
        <div class="user-main">
          <router-view/>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import vSidebar from '~c/common/Sidebar'

export default {
  name: 'User',
  components: {
    vSidebar
  }
}
</script>

<style scoped lang="scss">
  @import "../assets/css/base";

  .my-container {
    .search-nav {
      margin-top: 50px;
      width: 100%;
      height: 50px;
      border-bottom: 2px solid #B1191A;

      .search-nav-container {
        width: 80%;
        min-width: 1000px;
        height: 50px;
        margin: 0 auto;

        ul {
          margin: 0;
          padding-left: 0;
          list-style: none;

          li {
            cursor: pointer;
            margin: auto;
            line-height: 50px;
            color: #C81623;
            font-size: 16px;
            font-weight: bold;
            float: left;

            a {
              color: #C81623;
              text-decoration: none;
            }
          }

          li:first-child {
            padding: 0 38px;
            background: #B1191A;
            margin: 0;
            color: #fff;
          }
        }
      }
    }
    .main{
      margin-top: 25px;
      display: flex;
      .sidebar-main {
        width: 140px;
      }

      .user-main {
        width: 70%;
        margin: 0 auto;
      }
    }

  }
</style>
