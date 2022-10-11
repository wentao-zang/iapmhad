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
    <el-form-item label="" prop="basesx1">
      <el-input v-model="dataForm.basesx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesz1">
      <el-input v-model="dataForm.basesz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesx2">
      <el-input v-model="dataForm.basesx2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesz2">
      <el-input v-model="dataForm.basesz2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesx3">
      <el-input v-model="dataForm.basesx3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesz3">
      <el-input v-model="dataForm.basesz3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesx4">
      <el-input v-model="dataForm.basesx4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesz4">
      <el-input v-model="dataForm.basesz4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesx5">
      <el-input v-model="dataForm.basesx5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesz5">
      <el-input v-model="dataForm.basesz5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesqusx">
      <el-input v-model="dataForm.basesqusx" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesqusz">
      <el-input v-model="dataForm.basesqusz" placeholder=""></el-input>
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
          basesx1: '',
          basesz1: '',
          basesx2: '',
          basesz2: '',
          basesx3: '',
          basesz3: '',
          basesx4: '',
          basesz4: '',
          basesx5: '',
          basesz5: '',
          basesqusx: '',
          basesqusz: ''
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
          basesx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesx2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesz2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesx3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesz3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesx4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesz4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesx5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesz5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesqusx: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesqusz: [
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
              url: this.$http.adornUrl(`/yhpostureadjust/lsbasestan/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.lsBasestan.aircraftId
                this.dataForm.flightId = data.lsBasestan.flightId
                this.dataForm.fixtureId = data.lsBasestan.fixtureId
                this.dataForm.basesx1 = data.lsBasestan.basesx1
                this.dataForm.basesz1 = data.lsBasestan.basesz1
                this.dataForm.basesx2 = data.lsBasestan.basesx2
                this.dataForm.basesz2 = data.lsBasestan.basesz2
                this.dataForm.basesx3 = data.lsBasestan.basesx3
                this.dataForm.basesz3 = data.lsBasestan.basesz3
                this.dataForm.basesx4 = data.lsBasestan.basesx4
                this.dataForm.basesz4 = data.lsBasestan.basesz4
                this.dataForm.basesx5 = data.lsBasestan.basesx5
                this.dataForm.basesz5 = data.lsBasestan.basesz5
                this.dataForm.basesqusx = data.lsBasestan.basesqusx
                this.dataForm.basesqusz = data.lsBasestan.basesqusz
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
              url: this.$http.adornUrl(`/yhpostureadjust/lsbasestan/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'basesx1': this.dataForm.basesx1,
                'basesz1': this.dataForm.basesz1,
                'basesx2': this.dataForm.basesx2,
                'basesz2': this.dataForm.basesz2,
                'basesx3': this.dataForm.basesx3,
                'basesz3': this.dataForm.basesz3,
                'basesx4': this.dataForm.basesx4,
                'basesz4': this.dataForm.basesz4,
                'basesx5': this.dataForm.basesx5,
                'basesz5': this.dataForm.basesz5,
                'basesqusx': this.dataForm.basesqusx,
                'basesqusz': this.dataForm.basesqusz
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
