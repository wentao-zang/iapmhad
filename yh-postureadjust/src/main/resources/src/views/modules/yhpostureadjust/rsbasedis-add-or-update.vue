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
    <el-form-item label="" prop="basex1">
      <el-input v-model="dataForm.basex1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basez1">
      <el-input v-model="dataForm.basez1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basex2">
      <el-input v-model="dataForm.basex2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basez2">
      <el-input v-model="dataForm.basez2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basex3">
      <el-input v-model="dataForm.basex3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basez3">
      <el-input v-model="dataForm.basez3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basex4">
      <el-input v-model="dataForm.basex4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basez4">
      <el-input v-model="dataForm.basez4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basex5">
      <el-input v-model="dataForm.basex5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basez5">
      <el-input v-model="dataForm.basez5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesqux">
      <el-input v-model="dataForm.basesqux" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="basesquz">
      <el-input v-model="dataForm.basesquz" placeholder=""></el-input>
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
          basex1: '',
          basez1: '',
          basex2: '',
          basez2: '',
          basex3: '',
          basez3: '',
          basex4: '',
          basez4: '',
          basex5: '',
          basez5: '',
          basesqux: '',
          basesquz: ''
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
          basex1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basez1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basex2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basez2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basex3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basez3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basex4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basez4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basex5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basez5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesqux: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          basesquz: [
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
              url: this.$http.adornUrl(`/yhpostureadjust/rsbasedis/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.rsBasedis.aircraftId
                this.dataForm.flightId = data.rsBasedis.flightId
                this.dataForm.fixtureId = data.rsBasedis.fixtureId
                this.dataForm.basex1 = data.rsBasedis.basex1
                this.dataForm.basez1 = data.rsBasedis.basez1
                this.dataForm.basex2 = data.rsBasedis.basex2
                this.dataForm.basez2 = data.rsBasedis.basez2
                this.dataForm.basex3 = data.rsBasedis.basex3
                this.dataForm.basez3 = data.rsBasedis.basez3
                this.dataForm.basex4 = data.rsBasedis.basex4
                this.dataForm.basez4 = data.rsBasedis.basez4
                this.dataForm.basex5 = data.rsBasedis.basex5
                this.dataForm.basez5 = data.rsBasedis.basez5
                this.dataForm.basesqux = data.rsBasedis.basesqux
                this.dataForm.basesquz = data.rsBasedis.basesquz
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
              url: this.$http.adornUrl(`/yhpostureadjust/rsbasedis/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'basex1': this.dataForm.basex1,
                'basez1': this.dataForm.basez1,
                'basex2': this.dataForm.basex2,
                'basez2': this.dataForm.basez2,
                'basex3': this.dataForm.basex3,
                'basez3': this.dataForm.basez3,
                'basex4': this.dataForm.basex4,
                'basez4': this.dataForm.basez4,
                'basex5': this.dataForm.basex5,
                'basez5': this.dataForm.basez5,
                'basesqux': this.dataForm.basesqux,
                'basesquz': this.dataForm.basesquz
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
