<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="机型" prop="aircraftId">
      <el-input v-model="dataForm.aircraftId" placeholder="机型"></el-input>
    </el-form-item>
    <el-form-item label="架次" prop="flightId">
      <el-input v-model="dataForm.flightId" placeholder="架次"></el-input>
    </el-form-item>
    <el-form-item label="产品名称" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="产品名称"></el-input>
    </el-form-item>
    <el-form-item label="产品图号" prop="productNum">
      <el-input v-model="dataForm.productNum" placeholder="产品图号"></el-input>
    </el-form-item>
    <el-form-item label="任务代号" prop="taskId">
      <el-input v-model="dataForm.taskId" placeholder="任务代号"></el-input>
    </el-form-item>
    <el-form-item label="刀具编号" prop="toolId">
      <el-input v-model="dataForm.toolId" placeholder="刀具编号"></el-input>
    </el-form-item>
    <el-form-item label="孔号" prop="holeId">
      <el-input v-model="dataForm.holeId" placeholder="孔号"></el-input>
    </el-form-item>
    <el-form-item label="已加工孔数" prop="processNum">
      <el-input v-model="dataForm.processNum" placeholder="已加工孔数"></el-input>
    </el-form-item>
    <el-form-item label="总孔数" prop="totalNum">
      <el-input v-model="dataForm.totalNum" placeholder="总孔数"></el-input>
    </el-form-item>
    <el-form-item label="公称孔径" prop="holedia">
      <el-input v-model="dataForm.holedia" placeholder="公称孔径"></el-input>
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
          holedia: '',
          time: ''
        },
        dataRule: {
          aircraftId: [
            { required: true, message: '机型不能为空', trigger: 'blur' }
          ],
          flightId: [
            { required: true, message: '架次不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          productNum: [
            { required: true, message: '产品图号不能为空', trigger: 'blur' }
          ],
          taskId: [
            { required: true, message: '任务代号不能为空', trigger: 'blur' }
          ],
          toolId: [
            { required: true, message: '刀具编号不能为空', trigger: 'blur' }
          ],
          holeId: [
            { required: true, message: '孔号不能为空', trigger: 'blur' }
          ],
          processNum: [
            { required: true, message: '已加工孔数不能为空', trigger: 'blur' }
          ],
          totalNum: [
            { required: true, message: '总孔数不能为空', trigger: 'blur' }
          ],
          holedia: [
            { required: true, message: '公称孔径不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/yhmachinedrilling/productinfo/info/${this.dataForm.id}`),
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
                this.dataForm.holedia = data.productinfo.holedia
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
              url: this.$http.adornUrl(`/yhmachinedrilling/productinfo/${!this.dataForm.id ? 'save' : 'update'}`),
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
                'holedia': this.dataForm.holedia,
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
