<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('ame_hdym:statusinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('ame_hdym:statusinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        label="״̬ЅϢ">
      </el-table-column>
      <el-table-column
        prop="toolstatus"
        header-align="center"
        align="center"
        label="նޟ״̬">
      </el-table-column>
      <el-table-column
        prop="footopenstatus"
        header-align="center"
        align="center"
        label="ѹ݅ƸؗɬӶ">
      </el-table-column>
      <el-table-column
        prop="footclosestatus"
        header-align="center"
        align="center"
        label="ѹ݅Ƹؗ˵ۘ">
      </el-table-column>
      <el-table-column
        prop="cameracoveropenstatus"
        header-align="center"
        align="center"
        label="Ϡۺ؇Բߪ">
      </el-table-column>
      <el-table-column
        prop="cameracoverclosestatus"
        header-align="center"
        align="center"
        label="Ϡۺ؇٘ѕ">
      </el-table-column>
      <el-table-column
        prop="toolcoveropenstatus"
        header-align="center"
        align="center"
        label="նߢ؇Բߪ">
      </el-table-column>
      <el-table-column
        prop="toolcoverclosestatus"
        header-align="center"
        align="center"
        label="նߢ؇٘ѕ">
      </el-table-column>
      <el-table-column
        prop="toolsopenstatus"
        header-align="center"
        align="center"
        label="նߢ̧ɽ؋ɬӶ">
      </el-table-column>
      <el-table-column
        prop="toolsclosestatus"
        header-align="center"
        align="center"
        label="նߢ̧ɽ؋˵ۘ">
      </el-table-column>
      <el-table-column
        prop="holemeaopenstatus"
        header-align="center"
        align="center"
        label="ߗ̽ƸؗɬӶ">
      </el-table-column>
      <el-table-column
        prop="holemeaclosestatus"
        header-align="center"
        align="center"
        label="ߗ̽Ƹؗ˵ۘ">
      </el-table-column>
      <el-table-column
        prop="spopenstatus"
        header-align="center"
        align="center"
        label="主轴开">
      </el-table-column>
      <el-table-column
        prop="spclosestatus"
        header-align="center"
        align="center"
        label="主轴兿">
      </el-table-column>
      <el-table-column
        prop="oilopenstatus"
        header-align="center"
        align="center"
        label="油雾开关开吿">
      </el-table-column>
      <el-table-column
        prop="oilclosestatus"
        header-align="center"
        align="center"
        label="油雾开关关闿">
      </el-table-column>
      <el-table-column
        prop="recuropenstatus"
        header-align="center"
        align="center"
        label="回刀阀门开">
      </el-table-column>
      <el-table-column
        prop="recurclosestatus"
        header-align="center"
        align="center"
        label="回刀阀门关">
      </el-table-column>
      <el-table-column
        prop="flangeopenstatus"
        header-align="center"
        align="center"
        label="快换法兰开">
      </el-table-column>
      <el-table-column
        prop="flangeclosestatus"
        header-align="center"
        align="center"
        label="快换法兰兿">
      </el-table-column>
      <el-table-column
        prop="toolchangeropenstatus"
        header-align="center"
        align="center"
        label="换刀阀门开">
      </el-table-column>
      <el-table-column
        prop="toolchangerclosestatus"
        header-align="center"
        align="center"
        label="换刀阀门关">
      </el-table-column>
      <el-table-column
        prop="time"
        header-align="center"
        align="center"
        label="">
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
  import AddOrUpdate from './statusinfo-add-or-update'
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
          url: this.$http.adornUrl('/ame_hdym/statusinfo/list'),
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
            url: this.$http.adornUrl('/ame_hdym/statusinfo/delete'),
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
