<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="ۺЍ" prop="aircraftId">
      <el-input v-model="dataForm.aircraftId" placeholder="ۺЍ"></el-input>
    </el-form-item>
    <el-form-item label="ܜԎ" prop="flightId">
      <el-input v-model="dataForm.flightId" placeholder="ܜԎ"></el-input>
    </el-form-item>
    <el-form-item label="ҺƷûӆ" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="ҺƷûӆ"></el-input>
    </el-form-item>
    <el-form-item label="ҺƷͼڅ" prop="productNum">
      <el-input v-model="dataForm.productNum" placeholder="ҺƷͼڅ"></el-input>
    </el-form-item>
    <el-form-item label="٤ҕҎʽ" prop="taskId">
      <el-input v-model="dataForm.taskId" placeholder="٤ҕҎʽ"></el-input>
    </el-form-item>
    <el-form-item label="նޟѠڅ" prop="toolId">
      <el-input v-model="dataForm.toolId" placeholder="նޟѠڅ"></el-input>
    </el-form-item>
    <el-form-item label="ߗڅ" prop="holeId">
      <el-input v-model="dataForm.holeId" placeholder="ߗڅ"></el-input>
    </el-form-item>
    <el-form-item label="ܓ٤ʽ" prop="processNum">
      <el-input v-model="dataForm.processNum" placeholder="ܓ٤ʽ"></el-input>
    </el-form-item>
    <el-form-item label="ܓ٤לʽ" prop="totalNum">
      <el-input v-model="dataForm.totalNum" placeholder="ܓ٤לʽ"></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          aircraftId: '',
          flightId: '',
          productName: '',
          productNum: '',
          taskId: '',
          toolId: '',
          holeId: '',
          processNum: '',
          totalNum: '',
          time: ''
        },
        dataRule: {
          aircraftId: [
            { required: true, message: 'ۺЍ不能为空', trigger: 'blur' }
          ],
          flightId: [
            { required: true, message: 'ܜԎ不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: 'ҺƷûӆ不能为空', trigger: 'blur' }
          ],
          productNum: [
            { required: true, message: 'ҺƷͼڅ不能为空', trigger: 'blur' }
          ],
          taskId: [
            { required: true, message: '٤ҕҎʽ不能为空', trigger: 'blur' }
          ],
          toolId: [
            { required: true, message: 'նޟѠڅ不能为空', trigger: 'blur' }
          ],
          holeId: [
            { required: true, message: 'ߗڅ不能为空', trigger: 'blur' }
          ],
          processNum: [
            { required: true, message: 'ܓ٤ʽ不能为空', trigger: 'blur' }
          ],
          totalNum: [
            { required: true, message: 'ܓ٤לʽ不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/productinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.productinfo.aircraftId
                this.dataForm.flightId = data.productinfo.flightId
                this.dataForm.productName = data.productinfo.productName
                this.dataForm.productNum = data.productinfo.productNum
                this.dataForm.taskId = data.productinfo.taskId
                this.dataForm.toolId = data.productinfo.toolId
                this.dataForm.holeId = data.productinfo.holeId
                this.dataForm.processNum = data.productinfo.processNum
                this.dataForm.totalNum = data.productinfo.totalNum
                this.dataForm.time = data.productinfo.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/productinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'productName': this.dataForm.productName,
                'productNum': this.dataForm.productNum,
                'taskId': this.dataForm.taskId,
                'toolId': this.dataForm.toolId,
                'holeId': this.dataForm.holeId,
                'processNum': this.dataForm.processNum,
                'totalNum': this.dataForm.totalNum,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
