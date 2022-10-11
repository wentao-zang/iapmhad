<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="aircraftId">
      <el-input v-model="dataForm.aircraftId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="flightId">
      <el-input v-model="dataForm.flightId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fixtureId">
      <el-input v-model="dataForm.fixtureId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax1">
      <el-input v-model="dataForm.locax1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay1">
      <el-input v-model="dataForm.locay1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax2">
      <el-input v-model="dataForm.locax2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay2">
      <el-input v-model="dataForm.locay2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax3">
      <el-input v-model="dataForm.locax3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay3">
      <el-input v-model="dataForm.locay3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax4">
      <el-input v-model="dataForm.locax4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay4">
      <el-input v-model="dataForm.locay4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax5">
      <el-input v-model="dataForm.locax5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay5">
      <el-input v-model="dataForm.locay5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax6">
      <el-input v-model="dataForm.locax6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locapz1">
      <el-input v-model="dataForm.locapz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locapz2">
      <el-input v-model="dataForm.locapz2" placeholder=""></el-input>
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
          fixtureId: '',
          locax1: '',
          locay1: '',
          locax2: '',
          locay2: '',
          locax3: '',
          locay3: '',
          locax4: '',
          locay4: '',
          locax5: '',
          locay5: '',
          locax6: '',
          locapz1: '',
          locapz2: '',
          time: ''
        },
        dataRule: {
          aircraftId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          flightId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fixtureId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locapz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locapz2: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/yhpostureadjust/lqlocadis/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.lqLocadis.aircraftId
                this.dataForm.flightId = data.lqLocadis.flightId
                this.dataForm.fixtureId = data.lqLocadis.fixtureId
                this.dataForm.locax1 = data.lqLocadis.locax1
                this.dataForm.locay1 = data.lqLocadis.locay1
                this.dataForm.locax2 = data.lqLocadis.locax2
                this.dataForm.locay2 = data.lqLocadis.locay2
                this.dataForm.locax3 = data.lqLocadis.locax3
                this.dataForm.locay3 = data.lqLocadis.locay3
                this.dataForm.locax4 = data.lqLocadis.locax4
                this.dataForm.locay4 = data.lqLocadis.locay4
                this.dataForm.locax5 = data.lqLocadis.locax5
                this.dataForm.locay5 = data.lqLocadis.locay5
                this.dataForm.locax6 = data.lqLocadis.locax6
                this.dataForm.locapz1 = data.lqLocadis.locapz1
                this.dataForm.locapz2 = data.lqLocadis.locapz2
                this.dataForm.time = data.lqLocadis.time
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
              url: this.$http.adornUrl(`/yhpostureadjust/lqlocadis/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'locax1': this.dataForm.locax1,
                'locay1': this.dataForm.locay1,
                'locax2': this.dataForm.locax2,
                'locay2': this.dataForm.locay2,
                'locax3': this.dataForm.locax3,
                'locay3': this.dataForm.locay3,
                'locax4': this.dataForm.locax4,
                'locay4': this.dataForm.locay4,
                'locax5': this.dataForm.locax5,
                'locay5': this.dataForm.locay5,
                'locax6': this.dataForm.locax6,
                'locapz1': this.dataForm.locapz1,
                'locapz2': this.dataForm.locapz2,
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
