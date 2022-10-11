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
    <el-form-item label="产品图号" prop="productNum">
      <el-input v-model="dataForm.productNum" placeholder="产品图号"></el-input>
    </el-form-item>
    <el-form-item label="孔号" prop="holeId">
      <el-input v-model="dataForm.holeId" placeholder="孔号"></el-input>
    </el-form-item>
    <el-form-item label="孔径" prop="holediaMea">
      <el-input v-model="dataForm.holediaMea" placeholder="孔径"></el-input>
    </el-form-item>
    <el-form-item label="窝径" prop="pitdiaMea">
      <el-input v-model="dataForm.pitdiaMea" placeholder="窝径"></el-input>
    </el-form-item>
    <el-form-item label="齐平度" prop="eevenness">
      <el-input v-model="dataForm.eevenness" placeholder="齐平度"></el-input>
    </el-form-item>
    <el-form-item label="公称孔径" prop="holeDia">
      <el-input v-model="dataForm.holeDia" placeholder="公称孔径"></el-input>
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
          productNum: '',
          holeId: '',
          holediaMea: '',
          pitdiaMea: '',
          eevenness: '',
          holeDia: '',
          time: ''
        },
        dataRule: {
          aircraftId: [
            { required: true, message: '机型不能为空', trigger: 'blur' }
          ],
          flightId: [
            { required: true, message: '架次不能为空', trigger: 'blur' }
          ],
          productNum: [
            { required: true, message: '产品图号不能为空', trigger: 'blur' }
          ],
          holeId: [
            { required: true, message: '孔号不能为空', trigger: 'blur' }
          ],
          holediaMea: [
            { required: true, message: '孔径不能为空', trigger: 'blur' }
          ],
          pitdiaMea: [
            { required: true, message: '窝径不能为空', trigger: 'blur' }
          ],
          eevenness: [
            { required: true, message: '齐平度不能为空', trigger: 'blur' }
          ],
          holeDia: [
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
              url: this.$http.adornUrl(`/yhmachinedrilling/holemeasure/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.holeMeasure.aircraftId
                this.dataForm.flightId = data.holeMeasure.flightId
                this.dataForm.productNum = data.holeMeasure.productNum
                this.dataForm.holeId = data.holeMeasure.holeId
                this.dataForm.holediaMea = data.holeMeasure.holediaMea
                this.dataForm.pitdiaMea = data.holeMeasure.pitdiaMea
                this.dataForm.eevenness = data.holeMeasure.eevenness
                this.dataForm.holeDia = data.holeMeasure.holeDia
                this.dataForm.time = data.holeMeasure.time
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
              url: this.$http.adornUrl(`/yhmachinedrilling/holemeasure/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'productNum': this.dataForm.productNum,
                'holeId': this.dataForm.holeId,
                'holediaMea': this.dataForm.holediaMea,
                'pitdiaMea': this.dataForm.pitdiaMea,
                'eevenness': this.dataForm.eevenness,
                'holeDia': this.dataForm.holeDia,
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
