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
    <el-form-item label="" prop="locasx1">
      <el-input v-model="dataForm.locasx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy1">
      <el-input v-model="dataForm.locasy1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx2">
      <el-input v-model="dataForm.locasx2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy2">
      <el-input v-model="dataForm.locasy2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx3">
      <el-input v-model="dataForm.locasx3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy3">
      <el-input v-model="dataForm.locasy3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx4">
      <el-input v-model="dataForm.locasx4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy4">
      <el-input v-model="dataForm.locasy4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx5">
      <el-input v-model="dataForm.locasx5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy5">
      <el-input v-model="dataForm.locasy5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx6">
      <el-input v-model="dataForm.locasx6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locapsz1">
      <el-input v-model="dataForm.locapsz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locapsz2">
      <el-input v-model="dataForm.locapsz2" placeholder=""></el-input>
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
          locasx1: '',
          locasy1: '',
          locasx2: '',
          locasy2: '',
          locasx3: '',
          locasy3: '',
          locasx4: '',
          locasy4: '',
          locasx5: '',
          locasy5: '',
          locasx6: '',
          locapsz1: '',
          locapsz2: '',
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
          locasx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locapsz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locapsz2: [
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
              url: this.$http.adornUrl(`/yhpostureadjust/lqlocastan/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.lqLocastan.aircraftId
                this.dataForm.flightId = data.lqLocastan.flightId
                this.dataForm.fixtureId = data.lqLocastan.fixtureId
                this.dataForm.locasx1 = data.lqLocastan.locasx1
                this.dataForm.locasy1 = data.lqLocastan.locasy1
                this.dataForm.locasx2 = data.lqLocastan.locasx2
                this.dataForm.locasy2 = data.lqLocastan.locasy2
                this.dataForm.locasx3 = data.lqLocastan.locasx3
                this.dataForm.locasy3 = data.lqLocastan.locasy3
                this.dataForm.locasx4 = data.lqLocastan.locasx4
                this.dataForm.locasy4 = data.lqLocastan.locasy4
                this.dataForm.locasx5 = data.lqLocastan.locasx5
                this.dataForm.locasy5 = data.lqLocastan.locasy5
                this.dataForm.locasx6 = data.lqLocastan.locasx6
                this.dataForm.locapsz1 = data.lqLocastan.locapsz1
                this.dataForm.locapsz2 = data.lqLocastan.locapsz2
                this.dataForm.time = data.lqLocastan.time
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
              url: this.$http.adornUrl(`/yhpostureadjust/lqlocastan/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'locasx1': this.dataForm.locasx1,
                'locasy1': this.dataForm.locasy1,
                'locasx2': this.dataForm.locasx2,
                'locasy2': this.dataForm.locasy2,
                'locasx3': this.dataForm.locasx3,
                'locasy3': this.dataForm.locasy3,
                'locasx4': this.dataForm.locasx4,
                'locasy4': this.dataForm.locasy4,
                'locasx5': this.dataForm.locasx5,
                'locasy5': this.dataForm.locasy5,
                'locasx6': this.dataForm.locasx6,
                'locapsz1': this.dataForm.locapsz1,
                'locapsz2': this.dataForm.locapsz2,
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
