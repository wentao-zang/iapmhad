<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('processParametersJqrzk:fastenholeprocess:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('processParametersJqrzk:fastenholeprocess:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="数据条编号 自增">
      </el-table-column>
      <el-table-column
        prop="aperture"
        header-align="center"
        align="center"
        label="公称孔径">
      </el-table-column>
      <el-table-column
        prop="fastenType"
        header-align="center"
        align="center"
        label="紧固件类型">
      </el-table-column>
      <el-table-column
        prop="prefastenDode"
        header-align="center"
        align="center"
        label="预紧固件编号">
      </el-table-column>
      <el-table-column
        prop="toolId"
        header-align="center"
        align="center"
        label="刀具编号">
      </el-table-column>
      <el-table-column
        prop="holeDepth"
        header-align="center"
        align="center"
        label="制孔深度">
      </el-table-column>
      <el-table-column
        prop="dimpleDepth"
        header-align="center"
        align="center"
        label="锪窝深度">
      </el-table-column>
      <el-table-column
        prop="holeDepthMax"
        header-align="center"
        align="center"
        label="最大孔深">
      </el-table-column>
      <el-table-column
        prop="holeDepthMin"
        header-align="center"
        align="center"
        label="最小孔深">
      </el-table-column>
      <el-table-column
        prop="shaftRotaion"
        header-align="center"
        align="center"
        label="制孔主轴转速">
      </el-table-column>
      <el-table-column
        prop="shaftFeedRate"
        header-align="center"
        align="center"
        label="制孔进给速度">
      </el-table-column>
      <el-table-column
        prop="dimpleRotation"
        header-align="center"
        align="center"
        label="锪窝主轴转速">
      </el-table-column>
      <el-table-column
        prop="dimpleFeedRate"
        header-align="center"
        align="center"
        label="锪窝进给速度">
      </el-table-column>
      <el-table-column
        prop="presserForce"
        header-align="center"
        align="center"
        label="压脚压力">
      </el-table-column>
      <el-table-column
        prop="rapidFeedRate"
        header-align="center"
        align="center"
        label="快进速度">
      </el-table-column>
      <el-table-column
        prop="startPos"
        header-align="center"
        align="center"
        label="加工起始位置">
      </el-table-column>
      <el-table-column
        prop="insertSpeed"
        header-align="center"
        align="center"
        label="插钉速度">
      </el-table-column>
      <el-table-column
        prop="torque"
        header-align="center"
        align="center"
        label="拧紧扭矩">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './fastenholeprocess-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/processParametersJqrzk/fastenholeprocess/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/processParametersJqrzk/fastenholeprocess/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
